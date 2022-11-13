# 7 Days Of Code - Spring Framework (Alura)
7 Days Of Code - Spring Framework Challenge

The actual development status corresponds to the 3rd challenge day.

For this I'm consuming the IMDB top 250 movies API, and retrieving the response to an corresponding POJO with the movies.

You could import this repository and run the application in your favorite IDE or just run the JAR file.

Then you can test the result using your browser or other tool, passing the following URL:

http://localhost:8080/api/movies/top?apiKey=YOUR_IMDB_API_KEY

To create a free API key, as I've done, access the following [URL](https://imdb-api.com/Identity/Account/Register), and follow the steps.

After you are registered, you could get your API_KEY in your profile page.

=============================================================================================================================================

In the current version the tests have been adapted to match the new request pattern.

The requests itself are made by an specific class, to better delegate the responsibilities from the rest controller and the IMDB rest client.