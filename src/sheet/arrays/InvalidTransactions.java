package sheet.arrays;

import java.util.*;

public class InvalidTransactions {

    public static void main(String[] args) {
        InvalidTransactions invalidTxns = new InvalidTransactions();

        // input transactions, each string format: name,time,amount,cityu
        String[] transactions = {"alice,20,800,mtv", "alice,50,100,beijing"};

        // calling method to get invalid txns
        List<String> invalid = invalidTxns.invalidTransactions(transactions);

        // print the resultt
        System.out.println(invalid);
    }

    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;

        Set<Integer> invalids = new HashSet<>();  // will store indexes of invalid txns
        Map<String, List<Transaction>> nameToTxns = new HashMap<>();  // grouping by name

        Transaction[] txArr = new Transaction[n];

        // parsing each txn and grouping it by name
        for (int i = 0; i < n; i++) {
            Transaction t = Transaction.extract(transactions[i], i); // convert string to txn obj
            txArr[i] = t;
            nameToTxns.computeIfAbsent(t.name, k -> new ArrayList<>()).add(t);
        }

        // now check for invalid transaction condns
        for (List<Transaction> txList : nameToTxns.values()) {
            // sorting all txns of same person by time (increasing)..
            txList.sort(Comparator.comparingInt(t -> t.time));

            int size = txList.size();

            for (int i = 0; i < size; i++) {
                Transaction t1 = txList.get(i);

                // condition 1: amount is more than 1000
                if (t1.amount > 1000) {
                    invalids.add(t1.index);
                }

                // checking for other txns within 60 mins
                // NOTE: only compare with later txns since sorted by time
                for (int j = i + 1; j < size && txList.get(j).time - t1.time <= 60; j++) {
                    Transaction t2 = txList.get(j);

                    // if city is differnt but same name and within 60 mins, both are invalid
                    if (!t1.city.equals(t2.city)) {
                        invalids.add(t1.index);
                        invalids.add(t2.index); // dont forget this one too
                    }
                }
            }
        }

        // preparing result based on indexes
        List<String> invalidTxns = new ArrayList<>();

        for (Integer idx : invalids) invalidTxns.add(transactions[idx]);

        return invalidTxns;
    }
}

// custom class to hold txn data
class Transaction {
    String name;
    int time;
    int amount;
    String city;
    int index; // position in original array

    Transaction(String name, int time, int amount, String city, int index) {
        this.name = name;
        this.time = time;
        this.amount = amount;
        this.city = city;
        this.index = index;
    }

    // converts string to Transaction object
    static Transaction extract(String txnStr, int idx) {
        String[] parts = txnStr.split(","); // split by ,
        return new Transaction(
                parts[0],
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[2]),
                parts[3],
                idx
        );
    }
}