atm:
	mvn compile
	mvn exec:java -Dexec.mainClass=DojoPuzzle -Dexec.args=$(args)
	
teste1:
	mvn compile
	mvn exec:java -Dexec.mainClass=DojoPuzzle -Dexec.args=teste1.csv
	
teste2:
	mvn compile
	mvn exec:java -Dexec.mainClass=DojoPuzzle -Dexec.args=teste2.csv
