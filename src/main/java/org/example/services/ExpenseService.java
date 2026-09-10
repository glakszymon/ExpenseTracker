package org.example.services;

import org.example.services.models.ExpenseRecord;
import org.example.services.models.Result;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExpenseService {

    public Result<ExpenseRecord> AddAction(String description, int amount)
    {
        if(amount <= 0)
        {
            return Result.failure("You're amount can't be added");
        }

        var expenseRecordsList = Load();

        var record = new ExpenseRecord();
        record.Amount = amount;
        record.Description = description;
        record.ExpenseDateTime = LocalDateTime.now();

        if(expenseRecordsList.isEmpty())
            record.Id = 0;
        else
            record.Id = expenseRecordsList.getLast().Id + 1;

        expenseRecordsList.add(record);

        Save(expenseRecordsList);

        return Result.success(record, "");
    }

    public Result DeleteAction(int id)
    {
        if(id < 0)
        {
            return Result.failure("Id number must be greater then or equal to 0");
        }

        var expenseRecordsList = Load();

        boolean found = false;

        for (int i = 0; i < expenseRecordsList.size(); i++) {
            if (expenseRecordsList.get(i).Id == id) {
                expenseRecordsList.remove(i);
                found = true;
                break;
            }
        }
        if(!found)
        {
            return Result.failure("Id number is not existing. Try \"list\" command first");
        }

        expenseRecordsList = ReloadIds(expenseRecordsList);

        Save(expenseRecordsList);

        return Result.success("");
    }

    private List<ExpenseRecord> ReloadIds(List<ExpenseRecord> list)
    {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).Id = i;
        }

        return list;
    }

    public Result<List<ExpenseRecord>> ListAllAction()
    {
        var res = Load();
        return Result.success(res, "Success");
    }

    public Result<List<ExpenseRecord>> ListMonthAction(int monthNumber)
    {
        if(monthNumber > 12 || monthNumber < 1)
        {
            return Result.failure("Month number is incorrect");
        }

        var expenseRecordsList = Load();

        var answer = new ArrayList<ExpenseRecord>();

        for (int i = 0; i < expenseRecordsList.size(); i++) {
            var recordMonth = expenseRecordsList.get(i).ExpenseDateTime.getMonthValue();
            if(recordMonth == monthNumber)
            {
                answer.add(expenseRecordsList.get(i));
            }
        }

        return Result.success(answer, "Success");
    }

    public Result<Integer> SummaryAllAction()
    {
        int sum = 0;
        var expenseRecordList = Load();

        for (var rec : expenseRecordList)
        {
            sum += rec.Amount;
        }

        return Result.success(sum, "Sum calculated correctly");
    }

    public Result<Integer> SummaryMonthAction(int month)
    {
        if(month > 12 || month < 1)
        {
            return Result.failure("Month number is incorrect");
        }

        var expenseRecordList = ListMonthAction(month).data();

        int sum = 0;

        for(var t : expenseRecordList)
        {
            sum += t.Amount;
        }
        return Result.success(sum, "Sum calculated correctly");
    }

    private List<ExpenseRecord> Load()
    {
        var jsonFileRepository = new JsonFileRepository();
        var dataConverter = new DataConverter();

        return dataConverter.JSONArrayToData(jsonFileRepository.ReadFile());
    }

    private void Save(List<ExpenseRecord> records)
    {
        var jsonFileRepository = new JsonFileRepository();
        var dataConverter = new DataConverter();
        jsonFileRepository.SaveFile(dataConverter.DataToJSONArray(records));
    }
}
