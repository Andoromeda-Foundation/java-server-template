package com.powerbroker.resource.service;

import com.powerbroker.common.service.IndexItemService;
import com.powerbroker.common.utils.ReflectionUtils;
import com.powerbroker.report.data.model.IndexIdentifierAwareDTO;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

/**
 * @author william
 */
@Slf4j
public abstract class AbstractIndexService<ID extends Serializable, DTO extends IndexIdentifierAwareDTO> implements
        BeanFactoryAware, IndexItemService<ID, DTO> {

    @Setter
    protected BeanFactory beanFactory;

    protected Class<DTO> dtoClass;

    @Resource
    protected RedisTemplate<String, Object> redisTemplate;

    protected AbstractIndexService() {
        dtoClass = ReflectionUtils.getClassGenricType(getClass(), 1);
    }

    public DTO aggregate(DTO condition) {
        return null;
    }

    public List<DTO> history(DTO condition) throws ParseException {
        return null;
    }

    public List<DTO> realTime(DTO indexDischargeDTO) {
        return null;
    }

    BigDecimal setIfNull(BigDecimal value) {
        if (null == value) {
            return BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);
        }

        return value.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
