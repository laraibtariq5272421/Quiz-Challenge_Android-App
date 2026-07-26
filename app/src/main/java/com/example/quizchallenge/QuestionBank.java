package com.example.quizchallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionBank {

    public static List<Question> getQuestions() {
        List<Question> list = new ArrayList<>();

        list.add(new Question("What is the capital of Pakistan?",
                "Karachi", "Lahore", "Islamabad", "Peshawar", "C"));

        list.add(new Question("Who is known as the founder of Pakistan?",
                "Allama Iqbal", "Liaquat Ali Khan", "Muhammad Ali Jinnah", "Ayub Khan", "C"));

        list.add(new Question("On which date did Pakistan gain independence?",
                "23 March 1940", "14 August 1947", "6 September 1965", "27 October 1947", "B"));

        list.add(new Question("Which river is the longest in Pakistan?",
                "Ravi", "Chenab", "Indus", "Jhelum", "C"));

        list.add(new Question("What is the national language of Pakistan?",
                "Punjabi", "Urdu", "Sindhi", "Pashto", "B"));

        list.add(new Question("Which mountain range is known as the 'Roof of the World' and is located in Pakistan?",
                "Hindukush", "Karakoram", "Himalayas", "Sulaiman Range", "B"));

        list.add(new Question("What is the national sport of Pakistan?",
                "Cricket", "Football", "Hockey", "Squash", "C"));

        list.add(new Question("Which city is known as the 'City of Lights' in Pakistan?",
                "Lahore", "Karachi", "Multan", "Quetta", "B"));

        list.add(new Question("Who wrote the national anthem of Pakistan?",
                "Allama Iqbal", "Hafeez Jalandhari", "Faiz Ahmed Faiz", "Ahmed Faraz", "B"));

        list.add(new Question("Which is the largest province of Pakistan by area?",
                "Punjab", "Sindh", "Balochistan", "Khyber Pakhtunkhwa", "C"));

        Collections.shuffle(list);
        return list;
    }
}