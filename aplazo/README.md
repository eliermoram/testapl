{\rtf1\ansi\ansicpg1252\cocoartf2580
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;\f1\fnil\fcharset0 Menlo-Regular;}
{\colortbl;\red255\green255\blue255;\red0\green0\blue0;\red255\green255\blue255;\red0\green0\blue0;
\red0\green0\blue0;\red255\green255\blue255;}
{\*\expandedcolortbl;;\cssrgb\c0\c1\c1;\cssrgb\c100000\c100000\c99985\c0;\cssrgb\c0\c1\c1;
\cssrgb\c0\c1\c1;\cssrgb\c100000\c100000\c99985\c0;}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 $ docker build -t aplazo:lates .\
\
$ docker-compose up \'97build\
\
Service /health\cf2 \cb3 \
$ 
\f1\fs22 \cf2 \cb3 \CocoaLigature0 curl --location --request GET 'localhost:8081/health'\
\cf4 \cb3 \
Service calculate payments\
$ \cf2 \cb3 curl --location --request POST 'localhost:8081/generatePayment' --header 'Content-Type: application/json' --data-raw '\{\
\pard\tx560\tx1120\tx1680\tx2240\tx2800\tx3360\tx3920\tx4480\tx5040\tx5600\tx6160\tx6720\pardirnatural\partightenfactor0
\cf2 \cb3     "amount":100,\
    "terms":5,\
    "rate":10\
\}'\
\
Service return all credits\
$ \cf5 \cb6 curl --location --request GET 'localhost:8081/credits\'92}