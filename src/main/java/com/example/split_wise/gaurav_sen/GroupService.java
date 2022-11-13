//package com.example.split_wise.gaurav_sen;
//
//import java.util.List;
//import java.util.Map;
//
//public class GroupService {
//    ExpenseService expenseService;
//    Map<String, Group> groups; //assuming there is cache which is getting refreshed for groups
//    public GroupService(ExpenseService expenseService) {
//        this.expenseService = expenseService;
//    }
//    public PaymentGraph getGraphPayment(String groupId, String userId){
//        if(!groups.get(groupId).getUsers().contains(userId))
//            throw new IllegalArgumentException();
//        List<Expense> groupExpense= expenseService.getGroupExpenses(groupId);
//        Expense result= sumExpense(groupExpense);
//        return  expenseService.getPaymentGraph(result);
//    }
//
//    private Expense sumExpense(List<Expense> groupExpense) {
//        for(Expense expense: groupExpense){
//            for()
//        }
//    }
//
//    public Expense getBalance(String groupId){
//
//    }
//}
