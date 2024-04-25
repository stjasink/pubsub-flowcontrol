gcloud pubsub topics create test-topic --project=st-misc-demo
gcloud pubsub subscriptions create test-subscription --topic=test-topic --topic-project=st-misc-demo --project=st-misc-demo --ack-deadline=10
