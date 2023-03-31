<?php
require 'vendor/autoload.php';
$stripe = new \Stripe\StripeClient('sk_test_51MluAFEMbBMhBeVy54bI4xopHmSlaIJkhOBqDBhRUcm20cHjRHlXIjGG6V8MbMacWoapI8yKA8Psa1PHInzc6kh600eb4urSjV');

// Use an existing Customer ID if this is a returning customer.
$customer = $stripe->customers->create(
['name'=>"ICARE CHARITY",
 'address'=>[
   'line1'=>"Derrick",
   'postal_code'=>"039",
   'city'=>"Kisii",
   'country'=>"Kenya",]
]);
$ephemeralKey = $stripe->ephemeralKeys->create([
  'customer' => $customer->id,
], [
  'stripe_version' => '2022-08-01',
]);
$paymentIntent = $stripe->paymentIntents->create([
  'amount' => 1099,
  'currency' => 'eur',
  'customer' => $customer->id,
  'automatic_payment_methods' => [
    'enabled' => 'true',
  ],
]);

echo json_encode(
  [
    'paymentIntent' => $paymentIntent->client_secret,
    'ephemeralKey' => $ephemeralKey->secret,
    'customer' => $customer->id,
    'publishableKey' => 'pk_test_TYooMQauvdEDq54NiTphI7jx'
  ]
);
http_response_code(200);