#Author:lahari
@RegisterForm

Feature: Registration Form Filling



Scenario: checking title of Registration page
Given user is on the Registration page
Then check the title of Registartion page

Scenario: checking for valid details
Given user is on the Registration page
When user enters valid details
Then display success page

Scenario: checking invalid name
Given user is on the Registration page
When user enter invalid name
|lahari12|
|@%hdfh|
|12345|
|la ha |
||
Then display error message

Scenario: checking invalid mobile number
Given user is on the Registration page
When user enters invalid mobile number
|944192995|
|lahari|
|@$%&123|
|lahari123|
|1234567890|
|984561238789|
||
Then display error message


Scenario: check invalid email
Given user is on the Registration page
When user enters invalid email

|laha$@^@gmail|
|laharigmail.com|
|lahari.com|
|123&$|
|^%$&|
||
|lahari@gmail.com|
Then display error message

Scenario: check gender
Given user is on the Registration page
When user dont check gender
Then display error message for gender




