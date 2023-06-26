## Reactive Web Service
This is a project setup to learn spring flux and reactive programming


### Hitting the websocket from front end
```javascript
const socket = new WebSocket('ws://localhost:8080/websockettest');

socket.onopen = function () {
  console.log('WebSocket connection established.');

  // Send any initial messages to the server, if needed
};

socket.onmessage = function (event) {
  const message = event.data;
  console.log('Received message:', message);

  // Handle the received message here
};

socket.onclose = function () {
  console.log('WebSocket connection closed.');

  // Handle any cleanup or reconnection logic here, if needed
};


```