# Phonetic Searcher
Console application that finds phonetically equivalent words in text file for a list of words input by user.


## Requirements

* GIT
* Java Runtime Environment 8
* Maven

## Steps to run the application

1. Clone this repository:
```
$ git clone https://github.com/james-freitas/phoneticsearch
```
2. Access the folder and run Maven install command
```
$ cd phoneticsearch
$ mvn install
```
3. Execute the program using Maven
```
$ mvn exec:java -Dexec.args="word1 word2 .. wordN < dictionary_file_path"
```

### Important
 - Only use text files with extension .txt with one word in each line of the file
 - The parameters word1, word2 and wordN are words that the program will try to find equivalent on the dictionary.
 - The parameters should be space separated
 - Don't forget to use the character '<' after the last word and before the dictionary file path
 - You can put the dictionary file in the root of the folder of the program or in an absolute path


You can run the program against a sample dictionary using the maven command below:
```
$ mvn exec:java -Dexec.args="1ton# brief soon word_dict.txt"
```