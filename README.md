# Coding challenge

## Challenge 1 - Urlshortner

- Login with valid Credential.
- Click on Shorten Url from menu on left side.
- Enter any Url that you want to short or expand.
- It will print result below.

## Challenge 2

- Login with valid Credential.
- Click on Upload file from menu on left side.
- Upload a valid file.
- It will print result below.


## Challenge 3

- Login with valid Credential.
- Click on Convert Temperature from menu on left side.
- Enter any number in text field.
- It will print result below.


## Challenge 4

Please Url link below. I have added some dummy phone number in database. After hitting on URL it will return the result.

1. Get all phone numbers.
- http://ec2-54-218-118-36.us-west-2.compute.amazonaws.com/phone
It will return all phone numbers along with Customer name and id.

2. Get all phone numbers of a single customer
- http://ec2-54-218-118-36.us-west-2.compute.amazonaws.com/phone/{customerId}
Provide customer Id here. It will return result for one customer.

3. Activate a phone number
- http://ec2-54-218-118-36.us-west-2.compute.amazonaws.com/phone/activate/$number
Provide phone number here. It will activate that phone number.