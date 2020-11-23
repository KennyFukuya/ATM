# Requisitos:
	Java JDK/JRE 11
	Maven (sudo apt-get install maven)

# Descrição:
- O objetivo deste código é representar um caixa eletrônico, para isso é feita a instânciação de um ATM passando como parâmetro um ArrayList contendo a quantidade de notas disponíveis no ATM, onde -1 representa a quantidade infinita de notas. (A ordem é a seguinte: notas de 100, notas de 50, notas de 20 e notas de 10).
- Depois de instânciado o ATM, poderá ser feita uma série de saques de acordo com as notas disponíveis e também a quantidade de notas para cada tipo.
- A todo momento há tratamentos para consideração de erros durante a execução.
	
# Funcionamento:
- O cálculo de notas a serem sacadas foi realizado utilizando uma recursão onde o resultado está sendo armazenado em um TreeMap passado como parâmetro e alterado por referência. Essa abordagem foi utilizada com o intuito de diminuir a complexidade de tempo do algoritmo, fazendo com que ele seja mais otimizado.
- Para considerar a menor quantidade de notas as divisões são feitas partindo da nota de maior valor para a nota de menor valor.

# Roteiro de teste:
- make args=NOME_DO_ARQUIVO.CSV atm (ex: make args=teste1.csv atm)
- Para rodar os casos de testes criado por mim, executar os comandos 
		$ make teste1
			ou
		$ make teste2
- Caso queira criar novos testes, o formato do arquivo csv deve seguir a seguinte lógica:
		A linha inicial deve conter um valor inteiro para simbolizar a quantidade de notas para cada tipo disponíveis no caixa, onde -1 representa um número infinito de notas. A ordem dos valores é da maior nota para a menor nota.
		As linhas seguintes devem contem apenas um valor inteiro que representa a quantidade a ser sacada naquele caixa
		A cada saque efetuado com sucesso a quantidade de notas disponíveis no caixa é atualizada, caso o saque não ocorra, a quantidade de notas disponíveis sofre um rollback para não afetar o estado do caixa.
- Obs: Como esta sendo utilizado o maven, aparecerá mais mensagens no terminal, essas podem ser ignoradas!
- Obs: Caso queira esse codigo pode ser rodado no Intellij e outras IDE, basta importar a pasta como um projeto
