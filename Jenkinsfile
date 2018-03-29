#!/usr/bin/env groovy
pipeline {
    agent any
    stages('Initialize') {
        steps {
            sh '''
            echo "PATH = ${PATH}"
            '''
        }
    }
    stages('Build') {
        steps {
            echo "Hello world!"
        }
    }
}