COMP=javac
JAVA_FILES = src/Principal/*.java src/Mapas/*.java src/GUI/*.java 
BIN_DIR = ./bin/

build:
	mkdir -p $(BIN_DIR)
	$(COMP) -d $(BIN_DIR) $(JAVA_FILES)

run:
	java -classpath $(BIN_DIR) Inicio

clean:
	rm -rf ./bin/*
	
	