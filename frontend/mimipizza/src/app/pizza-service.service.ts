import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PizzaServiceService {
  constructor(private http: HttpClient) {}

  url1 = 'http://localhost:8080/pizza/';
  url2 = 'http://localhost:8080/orders/';
  url3 = 'http://localhost:8080/order/process';
  url4 = 'http://localhost:8080/userActions/';

  setStatus(status: string): Observable<any> {
    return this.http.post(
      `${this.url1}status?status=${status}`,
      {},
      { responseType: 'text' }
    );
  }

  //Decerator Pattern
  customizeOrder(
    extraToppings: boolean,
    specialPackaging: boolean
  ): Observable<any> {
    return this.http.post(
      `${this.url2}create?extraToppings=${extraToppings}&specialPackaging${specialPackaging}`,
      {},
      { responseType: 'text' }
    );
  }

  //state Pttern
  processOrder(): Observable<any> {
    return this.http.get(`${this.url3}`, { responseType: 'text' });
  }

  //chain of Responsibility (e.g., size, toppings, crust) === (e.g., Large, Cheese, Thin)
  PizzaCustomization(
    customizationType: string,
    customizationValue: string
  ): Observable<any> {
    return this.http.post(
      `${this.url1}customize?customizationType=${customizationType}&customizationValue=${customizationValue}`,
      {},
      { responseType: 'text' }
    );
  }

  //strategy pattern
  PizzaPayment(
    method: string,
    orderId: string,
    amount: string
  ): Observable<any> {
    return this.http.post(
      `${this.url1}pay?method=${method}&orderId=${orderId}&amount=${amount}`,
      {},
      { responseType: 'text' }
    );
  }

  //Factory Method
  PizzaRegister(name: string): Observable<any> {
    return this.http.post(
      `${this.url1}register?name=${name}`,
      {},
      { responseType: 'text' }
    );
  }

  PizzaStatus(status: string): Observable<any> {
    return this.http.post(
      `${this.url1}status?status=${status}`,
      {},
      { responseType: 'text' }
    );
  }

  //command pattern

  placeOrder(pizzaName: string): Observable<any> {
    return this.http.post(
      `${this.url4}placeOrder?pizzaName=${pizzaName}`,
      {},
      { responseType: 'text' }
    );
  }

  provideFeedback(feedback: string): Observable<any> {
    return this.http.post(
      `${this.url4}provideFeedback?feedback=${feedback}`,
      {},
      { responseType: 'text' }
    );
  }

  undo(): Observable<any> {
    return this.http.post(`${this.url4}undo`, {}, { responseType: 'text' });
  }
}
