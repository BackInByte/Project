#/bin/bash

echo "Compilation Logger"
javac -d logger/bin logger/src/logger/*.java

echo "Compilation restaurant"
javac -cp logger/bin -d restaurant/bin restaurant/src/restaurant/*.java

echo "Fin Compilation Bagel"


echo "Compilation tests"
javac -cp restaurant/bin:logger/bin -d testframework/bin testframework/src/test/*.java
echo "Fin Compilation tests"