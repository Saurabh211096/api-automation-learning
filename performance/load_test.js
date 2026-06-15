import http from 'k6/http';
import { check } from 'k6';

export const options = {
    vus: 10,
    iterations: 10,
};

export default function () {
    const response = http.get('https://petstore.swagger.io/v2/pet/1');

    check(response, {
        'status is 200': (r) => r.status === 200,
        'response time < 500ms': (r) => r.timings.duration < 500,
    });
};