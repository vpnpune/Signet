echo "Building using "$1"-Profile"
mvn clean compile -DskipTests
mvn clean package -DskipTests
cd target
java -jar -Dspring.profiles.active=$1 Signet-0.0.1-SNAPSHOT.jar -DskipTests
cd ..
$SHELL