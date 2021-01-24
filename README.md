# CovidExposureProbability

This project is a basic level statistical probability program that provides you with the likelyhood of your exposure to a covid positive individual given you provide your county, state and the number of interactions. The program follows a binomial probability model to predict this probability.

CALCULATION:
The calculation to calculate being exposed to a positive infection can rather be calculated by subtracting the probability of not being exposed at all by 1. This would provide you with the probability that at least one individual is covid-19 positive.

To do this, we first use existing published data to find the county proportion of individuals who have tested positive in the last 7 days. Subtracting the proportion of positive cases by 1 provides the probability of an individual not having the infection. Suppose: if 0.2 is the proportion of individuals being positive, it means 0.8 proportion of the population is covid negative.

Now given suppose the number of interactions is 10, 0.8 raised to the power of 10 provied the probability that each of those 10 interactions were with covid-19 negative individuals. Therefore,(1- ((0.8)^10)) would provide with the probability that at least one out of the 10 individuals is Covid-19 positive and thus provides with the probability to having been exposed to a Covid-19 positive individual.

Data Sources: 

Covid-19 Data on the number of county-level cases : Obtained via Usafacts covid trackerhttps://usafacts.org/visualizations/coronavirus-covid-19-spread-map/
County Populations: US census 2019 projections : https://www.census.gov/data/tables/time-series/demo/popest/2010s-state-total.html#par_textimage_1574439295
