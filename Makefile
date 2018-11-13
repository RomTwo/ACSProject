all: compile

compile:
	@javac src/Ihm/*.java src/Classe/*.java src/Contrat/*.java src/*.java

exec:
	@cd src/ && java Main

client:
	@cd src/ && java Client

server:
	@cd src/ && java Server

clean:
	@rm src/Ihm/*.class
	@rm src/Classe/*.class
	@rm src/Contrat/*.class
	@rm src/*.class