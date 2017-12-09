package services;

import entities.Contributor;
import entities.Repository;
import entities.RepositoryOwner;
import entities.User;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GitApiService {
    private String token = "b43f2d2aa7ed2a702c9f93f5676b37d823ecd548";
    private OrgJsonService jsonService;

    public GitApiService() {
        jsonService = new OrgJsonService();
    }

    public List<Repository> getMostStarredRpos(int page, int itemsPerPage) throws IOException, URISyntaxException {
        try {
            URI uri = new URIBuilder()
                    .setScheme("https")
                    .setHost("api.github.com")
                    .setPath("/search/repositories")
                    .setParameter("q", "stars:>1000")
                    .setParameter("sort", "stars")
                    .setParameter("order", "desc")
                    .setParameter("page", String.valueOf(page))
                    .setParameter("per_page", String.valueOf(itemsPerPage))
                    .build();

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(uri);
            request.setHeader("Authorization", "token " + token);

            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                InputStream inStream = httpEntity.getContent();
                Scanner scanner = new Scanner(inStream);
                StringBuilder builder = new StringBuilder();
                while (scanner.hasNext()) {
                    builder.append(scanner.next());
                }
                String json = builder.toString();
                System.out.println(json);
                ArrayList<Repository> repositories = jsonService.deserializeToRepository(json);
                for (Repository repository : repositories) {
                    System.out.println("---------------------------");
                    System.out.println("Name: " + repository.Name);
                    System.out.println("Description: " + repository.Description);
                    System.out.println("language: " + repository.Language);
                    System.out.println("Url: " + repository.Url);
                    System.out.println("Stars: " + repository.StarsCount);
                    System.out.println("---------------------------");
                }
                return repositories;
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("IO error");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new URISyntaxException("git api", "uri syntax error");
        }
    }

    public List<User> getGitHubUsers() throws URISyntaxException, IOException {
        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost("api.github.com")
                .setPath("/search/users")
                .setParameter("q", "type:user")
                .setParameter("sort", "repositories")
                .setParameter("order", "desc")
                .setParameter("page", "1")
                .setParameter("per_page", "10")
                .build();

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(uri);
        request.setHeader("Authorization", "token " + token);

        CloseableHttpResponse response = httpClient.execute(request);
        HttpEntity httpEntity = response.getEntity();
        if (httpEntity != null) {
            InputStream inStream = httpEntity.getContent();
            Scanner scanner = new Scanner(inStream);
            StringBuilder builder = new StringBuilder();
            while (scanner.hasNext()) {
                builder.append(scanner.next());
            }
            String json = builder.toString();
            System.out.println(json);
            ArrayList<User> users = jsonService.deserializeToUser(json);
            return users;
        }
        else {
            throw new NullPointerException("users not found");
        }
    }

    public List<Contributor> getRepositoryContributors(String ownerLogin, String repositoryName) throws URISyntaxException, IOException {
        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost("api.github.com")
                .setPath("/repos/" + ownerLogin + "/" + repositoryName + "/contributors")
                .setParameter("page", "1")
                .setParameter("per_page", "10")
                .build();

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(uri);
        request.setHeader("Authorization", "token " + token);

        CloseableHttpResponse response = httpClient.execute(request);
        HttpEntity httpEntity = response.getEntity();
        if (httpEntity != null) {
            InputStream inStream = httpEntity.getContent();
            Scanner scanner = new Scanner(inStream);
            StringBuilder builder = new StringBuilder();
            while (scanner.hasNext()) {
                builder.append(scanner.next());
            }
            String json = builder.toString();
            System.out.println(json);
            ArrayList<Contributor> contributors = jsonService.deserializeToContributor(json);
            return contributors;
        }
        else {
            throw new NullPointerException("users not found");
        }
    }

    public List<RepositoryOwner> getRepositoryOwners() throws URISyntaxException, IOException {
        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost("api.github.com")
                .setPath("/search/repositories")
                .setParameter("q", "stars:>1000")
                .setParameter("sort", "stars")
                .setParameter("order", "desc")
                .setParameter("page", "1")
                .setParameter("per_page", "10")
                .build();

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(uri);
        request.setHeader("Authorization", "token " + token);

        CloseableHttpResponse response = httpClient.execute(request);
        HttpEntity httpEntity = response.getEntity();
        if (httpEntity != null) {
            InputStream inStream = httpEntity.getContent();
            Scanner scanner = new Scanner(inStream);
            StringBuilder builder = new StringBuilder();
            while (scanner.hasNext()) {
                builder.append(scanner.next());
            }
            String json = builder.toString();
            System.out.println(json);
            ArrayList<RepositoryOwner> repositories = jsonService.deserializeToRepositoryOwners(json);
            return repositories;
        }
        else{
            throw new NullPointerException("respoitory owner not found");
        }
    }
}
