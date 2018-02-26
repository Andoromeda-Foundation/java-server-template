#!/bin/sh

BASE_PATH=../pb-migration/src/main/resources/migrations
DATETIME=`date +%Y%m%d%H%M%S`
NAME=$2

case "$1" in
	create)
	    FILENAME=V$DATETIME'__dml_'$NAME.sql
		echo 'Create' $FILENAME 
		touch $BASE_PATH/$FILENAME

		;;
	*)
		echo 'Command "'$1'" not exist!'
		exit 1
esac

exit 0
