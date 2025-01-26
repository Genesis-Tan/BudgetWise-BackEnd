package com.pinakabarato.BudgetWise.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.pinakabarato.BudgetWise.entity.Expense;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ExpenseService {
    private static final String COLLECTION_NAME = "expenses";

    public String saveExpense(Expense expense) throws ExecutionException, InterruptedException {
        Firestore firestoreDb = FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture = firestoreDb.collection(COLLECTION_NAME).document(expense.getName()).set(expense);
        return collectionApiFuture.get().getUpdateTime().toString();
    }
    public List<Expense> getAllExpenses() throws ExecutionException, InterruptedException {
        Firestore firestoreDb = FirestoreClient.getFirestore();
        List<Expense> expenses = new ArrayList<>();

        // Query Firestore to get all documents in the "expenses" collection
        ApiFuture<QuerySnapshot> query = firestoreDb.collection(COLLECTION_NAME).get();
        QuerySnapshot querySnapshot = query.get();

        // Convert Firestore documents to Expense objects
        for (QueryDocumentSnapshot document : querySnapshot.getDocuments()) {
            Expense expense = document.toObject(Expense.class);
            expenses.add(expense);
        }

        return expenses;
    }
}
