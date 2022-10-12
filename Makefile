JC=javac

.RECIPEPREFIX = >

build:
>  $(JC) ./src/*.java ./src/**/*.java -d bin

run:
>  java -cp bin: main

clean:
> rm bin/*
