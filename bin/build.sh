cd ~/NBArobot/
git pull
mvn clean package -DskipTests

PROCESS=`ps -ef|grep ciweb|grep -v grep|grep -v PPID|awk '{ print $2}'`
for i in $PROCESS
do
  echo "Kill the $1 process [ $i ]"
  kill -9 $i
done

nohup java -jar ~/NBArobot/target/nbarobot-0.0.1-SNAPSHOT.jar >server.log 2>&1 &

