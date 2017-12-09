package services;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class GitApiServiceTest {
    private static GitApiService gitApiService;

    @BeforeClass
    public static void setup(){
        gitApiService = new GitApiService();
    }

    @Test
    public void getMostStarredRpos() throws Exception {
        int exceptionCounter = 0;
        try {
            gitApiService.getMostStarredRpos(1, 10);
        }
        catch (Exception ex){
            exceptionCounter++;
        }
        assertEquals(0, exceptionCounter);
    }

    @Test
    public void getGitHubUsers() throws Exception {
        int exceptionCounter = 0;
        try {
            gitApiService.getGitHubUsers();
        }
        catch (Exception ex){
            exceptionCounter++;
        }
        assertEquals(0, exceptionCounter);
    }

    @Test
    public void getRepositoryContributors() throws Exception {
        int exceptionCounter = 0;
        try {
            gitApiService.getRepositoryContributors("freeCodeCamp", "freeCodeCamp");
        }
        catch (Exception ex){
            exceptionCounter++;
        }
        assertEquals(0, exceptionCounter);
    }

    @Test
    public void getRepositoryOwners() throws Exception {
        int exceptionCounter = 0;
        try {
            gitApiService.getRepositoryOwners();
        }
        catch (Exception ex){
            exceptionCounter++;
        }
        assertEquals(0, exceptionCounter);
    }

}