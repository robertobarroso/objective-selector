# Objective-Selector
You are combat droide YVH. This API will help you to determine the next enemy coordinate. Attack to the next enemy has never been so easy!

## Requirements
JDK 11 installed

## The input is composed by two lists:

- List of protocols: it is the strategy you want to apply in the combat. There are 6 protocols:
  - closest-enemies
  - furthest-enemies
  - assist-allies
  - avoid-crossfire
  - prioritize-mech
  - avoid-mech   
- List of coordinates: they are previosly retrieved from vision module. You can find bellow an example.

## Example request  
POST /radar HTTP/1.1 

```json
{
   "protocols":[
      "avoid-mech"
   ],
   "scan":[
      {
         "coordinates":{
            "x":0,
            "y":40
         },
         "enemies":{
            "type":"soldier",
            "number":10
         }
      },
      {
         "coordinates":{
            "x":0,
            "y":80
         },
         "allies":5,
         "enemies":{
            "type":"mech",
            "number":1
         }
      }
   ]
}
```


## cURL
curl --location --request POST 'http://localhost:8080/radar' \
--header 'Content-Type: application/json' \
--data-raw '{"protocols":["avoid-mech"],"scan":[{"coordinates":{"x":0,"y":40},"enemies":{"type":"soldier","number":10}},{"coordinates":{"x":0,"y":80},"allies":5,"enemies":{"type":"mech","number":1}}]}'

## Response
```json
{
    "x": 0,
    "y": 40
}
```

## How to run API
From command line run
```
gradlew bootRun
```
