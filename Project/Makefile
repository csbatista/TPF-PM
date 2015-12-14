COMP=javac
JAVA_FILES=src/Principal/*.java src/Mapas/*.java src/GUI/*.java src/*.java
BIN_DIR=bin/

.PHONY: build

build:
	mkdir -p $(BIN_DIR)
	$(COMP) -d $(BIN_DIR) $(JAVA_FILES)
	cp src/GUI/*.jpg $(BIN_DIR)GUI/
	cp src/GUI/*.png $(BIN_DIR)GUI/

run:
	java -classpath $(BIN_DIR) Inicio

clean:
	rm -rf ./bin/*
	rm -f *~
		
	
