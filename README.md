# CovidExposureProbability

This project is a basic level statistical probability program that provides you with the likelyhood of your exposure to a covid positive individual given you provide your county, state and the number of interactions. The program follows a binomial probability model to predict this probability.

CALCULATION:
The calculation to calculate being exposed to a positive infection can rather be calculated by suubtracting the probability of not being exposed at all by 1. This would provide you with the probability that at least one individual is covid-19 positive. To do this, we first use existing published data to find the county proportion of individuals who have tested positive in the last 7 days. Subtracting the proportion of positive cases by 1 provides the probability of an individual not having the infection. Suppose: if 0.2 is the proportion of individuals being positive, it means 0.8 proportion of the population is covid negative.

Now given suppose the number of interactions of 10. 0.8 raised to the power of 10 gives the probability that each of those 10 interactions were with covid-19 negative individuals. Therefore, $(1- (0.8)^10) would provide with the probability that at least one out of the 10 individuals is covid-19 positive.
