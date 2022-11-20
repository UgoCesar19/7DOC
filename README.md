# 7 Days Of Code - Spring Framework (Alura)
7 Days Of Code - Spring Framework Challenge

The challenge aims on **IMDB API** exploration.

You could import this repository and run the application in your favorite IDE or just run the JAR file.

Then you can test the result using your browser or other tool, passing the following addresses:

To view the result in the home page:
http://localhost:8080/home?apiKey=YOUR_IMDB_API_KEY

To return the list of movies as a Json:
http://localhost:8080/api/movies/top?apiKey=YOUR_IMDB_API_KEY

To create a free IMDB API key, as I've done, access the following [address](https://imdb-api.com/Identity/Account/Register), and follow the steps.

After you are registered, you could get your API_KEY in your profile page.

=============================================================================================================================================

## Change log

### Extra:
Implemented some user interface with basic navigation functionality.
Added to the project home an search form with an additional possibility of search (by movie crew).
The form was still constructed in Thymeleaf and based on bootstrap samples.
The movies card model changed too. Now there is a button on the card header that makes possible to add the movie to favorites list.

### 7th day:
Implemented the functionality of add movie to favorites, by clicking in the movie image.
Created a test that consumes our controllers, add 3 movies for favorites and get the page with the favorited movies.

### 6th day:
Added the possibility of movie filtering using the param "title": &title=movie_title_for_searsh.

### 5th day:
Encapsulation revision. All classes are already defined to better delegate and **encapsulate** the responsabilities.
Changed the annotation from the rest client from @Service to @Componnent, according to the chalenge proposition.

### 4th day:
A home page using thymeleaf was created.

### 3rd day:
New request pattern, filling plain old Java Objects (POJOs);
The requests itself are made by an specific class, to better delegate the responsibilities from the rest controller and the IMDB rest client.

### 2nd day:
Test classes for testing the IMDB API and the API based on the consume of the IMDB API.

### 1st day:
First deployment. An API was made based on the return of the Top 250 movies IMDB API. A request param must be provided to our API, passing the IMDB_API_KEY.