package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String textToDecorate, PoemDecorator poemDecorator) {
        String result =  poemDecorator.decorate(textToDecorate);
        System.out.println(result);
    }
}
