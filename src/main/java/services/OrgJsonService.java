package services;

import entities.Contributor;
import entities.Repository;
import entities.RepositoryOwner;
import entities.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class OrgJsonService {
    public ArrayList<Repository> deserializeToRepository(String json){
        JSONObject jsonObject = new JSONObject(json);
        JSONArray items = jsonObject.getJSONArray("items");
        ArrayList<Repository> repositories = new ArrayList<>();

        for (Object item : items) {
            JSONObject jsonRepo = (JSONObject) item;
            Repository repository = new Repository();
            repository.Name = (jsonRepo.get("full_name").toString());
            repository.Description = (jsonRepo.isNull("description") ? "" : jsonRepo.get("description").toString());
            repository.Language = (jsonRepo.isNull("language") ? "" : jsonRepo.get("language").toString());
            repository.StarsCount = (jsonRepo.getInt("stargazers_count"));
            repository.Url = (jsonRepo.getString("html_url"));
            repositories.add(repository);
        }

        return repositories;
    }

    public ArrayList<User> deserializeToUser(String json){
        JSONObject jsonObject = new JSONObject(json);
        JSONArray items = jsonObject.getJSONArray("items");
        ArrayList<User> users = new ArrayList<>();

        for (Object item : items) {
            JSONObject jsonUser = (JSONObject) item;
            User user = new User();
            user.Login = (jsonUser.get("login").toString());
            user.Score = (jsonUser.getInt("score"));
            user.Url = (jsonUser.get("url").toString());
            users.add(user);
        }

        return users;
    }

    public ArrayList<Contributor> deserializeToContributor(String json) {
        JSONArray items = new JSONArray(json);
        ArrayList<Contributor> contributors = new ArrayList<>();

        for (Object item : items) {
            JSONObject jsonUser = (JSONObject) item;
            Contributor contributor = new Contributor();
            contributor.Login = (jsonUser.get("login").toString());
            contributor.ContributionCount = (jsonUser.getInt("contributions"));
            contributors.add(contributor);
        }

        return contributors;
    }

    public int getCommitsCount(String json){
        try {
            validateJson(json);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        JSONArray itemsArray = new JSONArray(json);
        return itemsArray.length();
    }

    public HashMap<String, Integer> getContributors(String json, HashMap<String, Integer> map){
        try {
            validateJson(json);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        HashMap<String, Integer> result = map.isEmpty() ? new HashMap<>() : map;
        JSONArray commitsArray = new JSONArray(json);

        String key;
        int value;
        for (Object item : commitsArray){
            JSONObject jsonItem = (JSONObject) item;
            key = jsonItem.isNull("committer") ? "" : jsonItem.getJSONObject("committer").getString("login");
            if(result.keySet().contains(key)){
                value = result.get(key);
                result.replace(key, ++value);
            }
            else{
                result.put(key, 1);
            }
        }
        return result;
    }

    private void validateJson(String json) throws Exception {
        if(json.length() == 0) {
            throw new Exception("json is empty");
        }
    }

    public ArrayList<RepositoryOwner> deserializeToRepositoryOwners(String json) {
        JSONObject jsonObject = new JSONObject(json);
        JSONArray items = jsonObject.getJSONArray("items");
        ArrayList<RepositoryOwner> repositoryOwners = new ArrayList<>();

        for (Object item : items) {
            JSONObject jsonRepository = (JSONObject) item;
            JSONObject jsonOwner = jsonRepository.getJSONObject("owner");
            RepositoryOwner repositoryOwner = new RepositoryOwner();
            repositoryOwner.Login = (jsonRepository.get("full_name").toString());
            repositoryOwner.Url = (jsonRepository.get("url").toString());
            repositoryOwners.add(repositoryOwner);
        }

        return repositoryOwners;
    }
}
