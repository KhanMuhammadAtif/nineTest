library(ISwR)
data("cystfibr")
head(cystfibr)
#Checking missing values
table(is.na(cystfibr))
##Graphical representation of variables
library(GGally)
pm <- ggpairs(cystfibr, columns = c("weight","sex","bmp","fev1","rv","age","frc"))
pm
#Label categorical variable
cystfibr$sex <- factor(cystfibr$sex,
                       levels = c(0,1),
                       labels = c("male", "female"))
## Examine histogram for response variable
hist(cystfibr$pemax)
## checking linearity of weight with log(pemax)
### scatterplot
library(tidyverse)
cystfibr <- cystfibr %>% mutate(logpemax= log(pemax))
ggplot(cystfibr, aes(weight,logpemax)) + geom_point() + geom_smooth(method = "lm", se = FALSE)
hist(cystfibr$weight)
#model
model_weight <- lm(logpemax ~ weight, data = cystfibr)
summary(model_weight)
#Diagnostic
par(mfrow=c(3,2))
plot(model_weight, which = 1:6)
#model
model_weight_sex = lm(logpemax ~ weight + sex, data = cystfibr)
summary(model_weight_sex)
anova(model_weight_sex)
par(mfrow = c(3,2))
plot(model_weight_sex, which = 1:6)
model_weight_sex2 = lm(logpemax ~ weight * factor(sex), data = cystfibr)
summary(model_weight_sex2)
anova(model_weight_sex2)
plot(logpemax ~ weight, data=cystfibr)
lines(fitted(model_weight_sex2)[sex==1]~weight[sex==1],data=cystfibr,col="red")
lines(fitted(model_weight_sex2)[sex==0]~weight[sex==0],data=cystfibr,col="blue")
legend("bottomleft",legend=c("female","male"),lty=1,col=c("red","blue"))
par(mfrow = c(3,2))
plot(model_weight_sex2, which = 1:6)

#single covariate
m1 <- lm(logpemax ~ bmp, data = cystfibr)
summary(m1)
m2 <- lm(logpemax ~ fev1, data = cystfibr)
summary(m2)
m3 <- lm(logpemax ~ rv, data = cystfibr)
summary(m3)
m4 <- lm(logpemax ~ frc, data = cystfibr)
summary(m4)
m5 <- lm(logpemax ~ weight+fev1+frc, data = cystfibr)
summary(m5)
m6 <- lm(logpemax ~ weight+fev1+rv, data = cystfibr)
summary(m6)
m6 <- lm(logpemax ~ weight+fev1, data = cystfibr)
summary(m6)
m7 <- lm(logpemax ~ weight+bmp, data = cystfibr)
summary(m7)
model1 <- lm(logpemax~weight+bmp+fev1+rv, data = cystfibr)
summary(model1)
anova(model1)
model2 <- lm(logpemax~weight+bmp+fev1+frc, data = cystfibr)
summary(model2)
anova(model2)
#final model
model3 <- lm(logpemax~weight+bmp+fev1, data = cystfibr)
summary(model3)
anova(model3)
model4 <- lm(logpemax~weight+bmp, data = cystfibr)
summary(model4)
anova(model4)
#Diagnostic
par(mfrow = c(3,2))
plot(model3, which = 1:6)