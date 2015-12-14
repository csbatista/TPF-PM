COMP=javac
JAVA_FILES=src/EstadosJogador/*.java src/Mapas/*.java src/GUI/*.java src/Jogador/*.java src/*.java
BIN_DIR = bin/


.PHONY: build

build:
	mkdir -p $(BIN_DIR)
	$(COMP) -d $(BIN_DIR) $(JAVA_FILES)
	
	mkdir -p $(BIN_DIR)GUI/img
	mkdir -p $(BIN_DIR)GUI/audio
	cp src/GUI/img/* $(BIN_DIR)GUI/img
	cp src/GUI/audio/* $(BIN_DIR)GUI/audio


run:
	java -classpath $(BIN_DIR) Inicio

clean:
	rm -rf ./bin/*
	rm -f *~	
	
