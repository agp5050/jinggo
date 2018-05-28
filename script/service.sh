#!/bin/bash
#####################################################Environment Setting#######################################################

#程序代码数组
APPS=(myservice1 service2)

#程序名称数组
NAMES=(配置模块 网关模块)

#jar包数组
JARS=(sf-config-service.jar sf-edge-service.jar)

#jar包路径数组
PATHS=(/jdata/services/services)

start(){
	local APPNAME=
	local NAME=
	local CLASSNAME=
	local PROJECTDIR=
	local command="sh service.sh start"
	local cmd2="$1"
	local cmd2ok=0
	local cnt=0
	local okcnt=0
	#local C_PID="0"
	#for i in `seq 0 22`
	echo "---------------------------开始启动服务..."
	for(( i=0;i<${#APPS[@]};i++))
		do
			APPNAME=${APPS[$i]}
			NAME=${NAMES[$i]}
			CLASSNAME=${JARS[$i]}
			PROJECTDIR=${PATHS[$i]}
		if [ "$cmd2" == "all" ] || [ "$cmd2" == "$APPNAME" ]; then
			cmd2ok=1
			C_PID="0"
			cnt=0
			#ps -ef | grep "$CLASSNAME" | awk '{print $2}' | while read pid
			PID=`ps -ef |grep $(echo $CLASSNAME |awk -F/ '{print $NF}') | grep -v grep | awk '{print $2}'`
			#do
			#C_PID=$(ps --no-heading $pid | wc -l)
			#if [ "$C_PID" == "1" ]; then
		if [ -n "$PID" ]
		then
			echo "$APPNAME---$NAME:己经运行,PID=$PID"
			#okcnt=$(($okcnt+1))
		else
			cd $PROJECTDIR
			rm -f $PROJECTDIR/nohup.out
			command="nohup java -jar $CLASSNAME"
			exec $command >> $PROJECTDIR/nohup.out &
			#ps -ef | grep "$CLASSNAME" | awk '{print $2}' | while read pid
			#do
			# C_PID=$(ps --no-heading $pid | wc -l)
			#done
			PID=`ps -ef |grep $(echo $CLASSNAME |awk -F/ '{print $NF}') | grep -v grep | awk '{print $2}'`
			cnt=0
		#while (("$C_PID" == "0"))
		while [ -z "$PID" ]
			do
				if (($cnt==30))
			then
				echo "$APPNAME---$NAME:$cnt秒内未启动，请检查！"
				break
			fi
				cnt=$(($cnt+1))
				sleep 1s
				#ps -ef | grep "$CLASSNAME" | awk '{print $2}' | while read pid
				#do
				# C_PID=$(ps --no-heading $pid | wc -l)
				#done
				PID=`ps -ef |grep $(echo $CLASSNAME |awk -F/ '{print $NF}') | grep -v grep | awk '{print $2}'`
				done
				okcnt=$(($okcnt+1))
				echo "$APPNAME---$NAME:己经成功启动,PID=$PID"
				#出借模块和总装模块启动较慢
				if [ "$APPNAME" == "deal" ] ;
					then
					echo "$APPNAME---$NAME:启动中..."
					sleep 30s
				fi
					if [ "$APPNAME" == "dispatch" ] ;
						then
						echo "$APPNAME---$NAME:启动中..."
						sleep 10s
					fi
				fi
				#done
			fi
				done
				if (($cmd2ok==0))
				then
				echo "command2: all|pushcode|thirdpayment|security|redis|commservice|wechat|point|useraccount|coupon|interest|experience|dealaccount|user|send|payment|sms|deal|dispatch|dealload|recv|innermsg|reward|finacial|debt"
				else
				echo "---------------------------本次启动:$okcnt个服务"
			fi

}