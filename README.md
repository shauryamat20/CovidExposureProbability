# CovidExposureProbability

This project is a statistical probability modelling program that provides you with the likelyhood of your exposure to a covid positive individual from computation that follows information given you provide your county, state and the number of interactions. The program follows a binomial probability model to predict this probability.

CALCULATION:
The calculation to calculate being exposed to a positive infection can rather be calculated by subtracting the probability of not being exposed at all by 1. This would provide you with the probability that at least one individual is covid-19 positive.

To do this, we first use existing published data to find the county proportion of individuals who have tested positive in the last 7 days. Subtracting the proportion of positive cases by 1 provides the proportion of individuals not having the infection. Suppose: if 0.2 is the percent of individuals being positive, it means 0.8 percent of the population is covid-19 negative.

Given these proportions along with population informaiton from US census and the covid-19 numbers from the CDC, we compute the binomial probability of being exposed to the virus.

Data Sources: 

Covid-19 Data on the number of county-level cases : Obtained via Usafacts covid tracker: https://usafacts.org/visualizations/coronavirus-covid-19-spread-map/

County Populations: US census 2019 projections : https://www.census.gov/data/tables/time-series/demo/popest/2010s-state-total.html#par_textimage_1574439295
