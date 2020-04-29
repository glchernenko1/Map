package com.company;

import java.util.*;

import static java.lang.Runtime.getRuntime;


public class House {
    private ArrayList<Flat> apartments;

    public House() {
        apartments = new ArrayList<Flat>();
    }

    public void addApartment(Flat in) {
        apartments.add(in);
    }

    private class ExampleThread extends Thread {
        private ArrayList<Flat> apartments;
        private HashMap<Integer, Integer> map;
        private int head;
        private int end;

        public void setData(ArrayList<Flat> inApartments, HashMap<Integer, Integer> inMap, int inHead, int inEnd) {
            apartments = inApartments;
            map = inMap;
            head = inHead;
            end = inEnd;
        }

        public void run() {
            int count = 0;

            for (int i = head; i < end; ++i) {
                Integer tmpRoom = apartments.get(i).getNumberOfRooms();
                map.merge(tmpRoom, 1, Integer::sum);

            }
        }

    }

    // кажется тут нужна синхронизация потому что с большим количеством потоков работает неверно вообщем
// много поток был сделан из за интереса ))) и для правильной работы нужно раскоментировать код ниже а этот)
    public HashMap<Integer, Integer> count() throws InterruptedException {
        HashMap<Integer, Integer> answer = new HashMap<Integer, Integer>();
        int lenght = apartments.size();
        int sizeOfThread = Math.min(lenght, getRuntime().availableProcessors() );
        int size = (int) lenght / sizeOfThread;
        ExampleThread[] tr = new ExampleThread[sizeOfThread];
        int head = 0;
        for (int i = 0; i < sizeOfThread; ++i) {
            tr[i] = new ExampleThread();
            int end = head + size;
            if (i == sizeOfThread - size && sizeOfThread % 2 != 0) end = lenght;
            tr[i].setData(apartments, answer, head, end);
            tr[i].start();
            head = end;
        }

        for (int i = 0; i < sizeOfThread; ++i) {
            tr[i].join();
        }
        // Рабочий код
//        HashMap<Integer, Integer> answer = new HashMap<Integer, Integer>();
//        ExampleThread tr1 = new ExampleThread();
//        tr1.setData(apartments, answer, 0, apartments.size());
//        tr1.start();
//        tr1.join();

        return answer;

    }

    ArrayList<Flat> getGreatestInAreaFlats(int flats) {
        Comparator square = new FlatAreaComparator();
        Collections.sort(apartments, square);
        ArrayList<Flat> out = new ArrayList<Flat>();
        for (int i = 0; i < flats; ++i)
            out.add(apartments.get(i));
        return out;
    }
}

