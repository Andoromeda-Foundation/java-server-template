#!/bin/sh

BASE_PATH=../pb-administration/pb-administration-resource-server/src/main/java/com/powerbroker/resource
MODEL=$2

case "$1" in
	create)
		echo 'Create' $MODEL

		sed 's/{{Target}}/'$MODEL'/g' ./template/Entity.java > $BASE_PATH/entity/$MODEL.java
		sed 's/{{Target}}/'$MODEL'/g' ./template/DAO.java > $BASE_PATH/dao/"$MODEL"DAO.java
		sed 's/{{Target}}/'$MODEL'/g' ./template/DTO.java > $BASE_PATH/model/"$MODEL"DTO.java
		sed 's/{{Target}}/'$MODEL'/g' ./template/Service.java > $BASE_PATH/service/"$MODEL"Service.java
		sed 's/{{Target}}/'$MODEL'/g' ./template/DefaultService.java > $BASE_PATH/service/Default"$MODEL"Service.java
		sed 's/{{Target}}/'$MODEL'/g' ./template/Controller.java > $BASE_PATH/controller/"$MODEL"Controller.java

		;;
	remove)
		echo 'Remove' $MODEL

		rm -rf $BASE_PATH/entity/$MODEL.java
		rm -rf $BASE_PATH/dao/"$MODEL"DAO.java
		rm -rf $BASE_PATH/model/"$MODEL"DTO.java
		rm -rf $BASE_PATH/service/"$MODEL"Service.java
		rm -rf $BASE_PATH/service/Default"$MODEL"Service.java
		rm -rf $BASE_PATH/controller/"$MODEL"Controller.java

		;;
	*)
		echo 'Command "'$1'" not exist!'
		exit 1
esac

exit 0
