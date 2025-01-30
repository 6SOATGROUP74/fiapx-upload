#!/bin/bash
kubectl apply -f ./app/app-nlb.yaml
kubectl apply -f ./app/app-hpa.yaml
kubectl apply -f ./app/app-deployment.yaml
kubectl apply -f ./app/app-svc.yaml
kubectl apply -f ./service-account.yaml

