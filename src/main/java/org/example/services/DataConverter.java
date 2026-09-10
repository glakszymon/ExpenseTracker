package org.example.services;

import org.example.services.models.ExpenseRecord;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataConverter {
    public JSONArray DataToJSONArray (List<ExpenseRecord> data)
    {
        var result = new JSONArray();

        for(ExpenseRecord rec : data)
        {
            JSONObject obj = new JSONObject();
            obj.put("id", rec.Id);
            obj.put("amount", rec.Amount);
            obj.put("description", rec.Description);
            obj.put("expenseDateTime", rec.ExpenseDateTime.toString());

            result.add(obj);
        }

        return result;
    }

    public List<ExpenseRecord> JSONArrayToData(JSONArray array)
    {
        var result = new ArrayList<ExpenseRecord>();

        for(Object record : array)
        {
            JSONObject rec = (JSONObject) record;
            Long tempAmount = (Long) rec.get("amount");
            Long tempID = (Long) rec.get("id");
            String tempDateTime = (String) rec.get("expenseDateTime");

            var temp = new ExpenseRecord();
            temp.Id = tempID.intValue();
            temp.Amount = tempAmount.intValue();
            temp.Description = (String) rec.get("description");
            temp.ExpenseDateTime = LocalDateTime.parse(tempDateTime);

            result.add(temp);
        }

        return result;
    }
}
