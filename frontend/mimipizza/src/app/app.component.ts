import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PizzShopComponent } from './pizz-shop/pizz-shop.component';
import { PizzaOrderComponent } from './pizza-order/pizza-order.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, PizzaOrderComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'mimipizza';
}
