.PHONY: all say_hello generate clean

all: say_hello generate

say_hello:
	echo "This command is displayed"
	@echo "This command will not be displayed"

generate:
	@echo "Creating empty text files..."
	touch file-{1..10}.txt

clean:
	@echo "Cleaning up..."
	rm *.txt

