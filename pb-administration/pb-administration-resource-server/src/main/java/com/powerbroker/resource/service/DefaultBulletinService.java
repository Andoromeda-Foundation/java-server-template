package com.powerbroker.resource.service;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.common.utils.ValueUtil;
import com.powerbroker.resource.dao.BulletinDAO;
import com.powerbroker.resource.dao.ReadReceiptDAO;
import com.powerbroker.resource.entity.Bulletin;
import com.powerbroker.resource.entity.ReadReceipt;
import com.powerbroker.resource.model.BulletinDTO;
import com.powerbroker.resource.model.BulletinStateDTO;
import com.powerbroker.resource.model.ReadReceiptDTO;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultBulletinService extends AbstractJPAService<Long, BulletinDTO, Bulletin, BulletinDAO> implements BulletinService {

    @Resource
    private ReadReceiptDAO readReceiptDAO;

    @Override
    public Page<BulletinDTO> listActive(Pageable pageable) {

        Bulletin probe = new Bulletin();
        probe.setObject(getAuthType());
        Example<Bulletin> example = Example.of(probe);
        Page<Bulletin> data = dao.findAll(example, pageable);

        Collection<Long> ids = data.getContent().stream().map(bulletin -> bulletin.getId()).collect(Collectors.toList());

        Collection<ReadReceipt> readReceipts = readReceiptDAO.findByBulletinIdIn(ids);
        Map<Long, ReadReceipt> readReceiptMap = readReceipts.stream().collect(Collectors.toMap(ReadReceipt::getBulletinId, Function.identity()));

        return data.map(entity -> {
            BulletinDTO bulletinDTO = ValueUtil.dump(entity, dtoClass);

            if (readReceiptMap.containsKey(entity.getId())) {
                bulletinDTO.setReadReceipt(ValueUtil.dump(readReceiptMap.get(entity.getId()), ReadReceiptDTO.class));
            }

            return bulletinDTO;
        });
    }

    @Override
    public BulletinDTO retrieve(Long aLong) {
        BulletinDTO retrieve = super.retrieve(aLong);

        if (null != retrieve.getObject() && retrieve.getObject().intValue() == getAuthType().intValue()) {
            return retrieve;
        }

        return null;
    }

    @Override
    @Transactional
    public void read(Long id) {
        if (null != this.dao.findOne(id)) {
            ReadReceipt readReceipt = readReceiptDAO.findByBulletinId(id);
            if (null == readReceipt) {
                readReceipt = new ReadReceipt();
            }
            readReceipt.setBulletinId(id);
            readReceipt.setObject(getAuthType());
            readReceipt.setReadBy(getCurrentAuthUserId());
            readReceiptDAO.save(readReceipt);
        }
    }

    @Override
    public BulletinStateDTO state() {

        long count = this.dao.countByObject(getAuthType());
        long readCount = this.readReceiptDAO.countByReadByAndObject(getCurrentAuthUserId(), getAuthType());

        BulletinStateDTO bulletinState = new BulletinStateDTO();
        bulletinState.setAllCount(count);
        bulletinState.setReadCount(readCount);
        return bulletinState;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        ReadReceipt readReceipt = readReceiptDAO.findByBulletinId(id);
        if (null != readReceipt) {
            readReceiptDAO.delete(readReceipt);
        }
        return super.delete(id);
    }
}
