package com.example.android.libjavajokesprovider;

import java.util.Random;

public class Joker {

    //Definitions of the jokes by category

    private static final String[] KIDS = {
            "What do you call a dinosaur that is sleeping?\n" + "A dino-snore!\n",
            "What is fast, loud and crunchy?\n" + "A rocket chip!\n",
            "Why did the teddy bear say no to dessert?\n" + "Because she was stuffed.\n"
    };

    private static final String[] ANIMALS = {
            "How does a lion greet the other animals in the field?\n" + "Pleased to eat you.\n",
            "What do you give a dog with a fever?\n" + "Mustard, its the best thing for a hot dog!\n",
            "How do spiders communicate?\n" + "Through the World Wide Web.\n"
    };

    private static final String[] MUSICIANS = {
            "What's the difference between a banjo and an onion? \n" + "A: Nobody cries when you chop up a banjo. \n",
            "What Do You Call Two Guitarists Playing In Unison?\n" + "Counterpoint. \n",
            "There Were Two People Walking Down The Street. One Was A Musician.\n" + "The Other Didn”T Have Money Either. \n"
    };

    private static final String[] DOCTORS = {
            "Patient: Doctor, I think I need glasses.\n" + "Teller: You certainly do! This is a bank. \n",
            "Patient: Doctor, I get heartburn every time I eat birthday cake.\n" + "Doctor: Next time, take off the candles. \n",
            "Doctor: I have some bad news and some very bad news.\n" + "Patient: Well, might as well give me the bad news first.\n" +
            "Doctor: The lab called with your test results. They said you have 24 hours to live.\n" +
            "Patient: 24 HOURS! That’s terrible!! WHAT could be WORSE? What’s the very bad news?\n" +
            "Doctor: I’ve been trying to reach you since yesterday. \n"
    };

    private static final String[] MARRIAGE = {
            "Q: If love is “grand,” what is divorce?\n" +
            "A: A hundred grand, or more.",
            "Wife: “Our new neighbor always kisses his wife when he leaves for work. Why don’t you do that?”\n" +
            "Husband: “How can I? I don’t even know her.”",
            "Marriage is a three-ring circus: engagement ring, wedding ring, and suffering."
    };

    private static final String[] KNOCKKNOCK = {
            "Knock, knock.\n" +
            "Who’s there?\n" +
            "Canoe.\n" +
            "Canoe who?\n" +
            "Canoe help me with my homework?",
            "Knock, knock\n" +
            "Who’s there?\n" +
            "Merry.\n" +
            "Merry who?\n" +
            "Merry Christmas!",
            "Knock, knock.\n" +
            "Who’s there?\n" +
            "Anee.\n" +
            "Anee,who?\n" +
            "Anee one you like!"
    };

    // Return a random joke between [0-2] selected by category
    public String getJoke(String category) {

        Random r = new Random();
        int low = 0;
        int high = 2;
        int random = r.nextInt(high-low) + low;

        switch (category) {
            case "KIDS":
                return KIDS[random];

            case "ANIMALS":
                return ANIMALS[random];

            case "MUSICIANS":
                return MUSICIANS[random];

            case "DOCTORS":
                return DOCTORS[random];

            case "MARRIAGE":
                return MARRIAGE[random];

            case "KNOCKKNOCK":
                return KNOCKKNOCK[random];
        }

        return "No joke today";
    }
}
