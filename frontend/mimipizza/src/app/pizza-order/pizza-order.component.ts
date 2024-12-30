import { Component } from '@angular/core';
import { PizzaServiceService } from '../pizza-service.service';
import { inject } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { NgModule } from '@angular/core';
import { MatCommonModule } from '@angular/material/core';
import { FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';
import { CommonModule } from '@angular/common';
import { MatDialog } from '@angular/material/dialog';
import { UserProfilePopupComponent } from '../user-profile-popup/user-profile-popup.component';

@Component({
  selector: 'app-pizz-order',
  imports: [MatCardModule, MatCommonModule, FormsModule, CommonModule],
  templateUrl: './pizza-order.component.html',
  styleUrl: './pizza-order.component.css',
})
export class PizzaOrderComponent {
  pizzaService = inject(PizzaServiceService);

  constructor() {}

  private dialog = inject(MatDialog);

  pizzas = [
    { name: 'Margherita', description: 'Classic Cheese Pizza', price: 32 },
    { name: 'Pepperoni', description: 'Spicy Pepperoni Pizza', price: 15 },
    { name: 'Veggie', description: 'Loaded Veggie Pizza', price: 13 },
  ];
  selectedPizza: any = null;
  pizzaSize = '';
  topping = '';
  crust = '';
  extraToppings = false;
  specialPackaging = false;
  showCustomizationPopup = false;
  customizationType = 'Size , Topping , Crust';
  customizationValue = '';

  userProfile: any = null;

  createProfilePopup() {
    alert('Redirecting to profile creation...');
  }

  orderList: any[] = []; // To store added pizzas

  openCustomizationPopup(pizza: any) {
    this.selectedPizza = pizza;
    this.showCustomizationPopup = true;
  }

  addToOrder() {
    const customizedPizza = {
      ...this.selectedPizza,
      size: this.pizzaSize,
      topping: this.topping,
      crust: this.crust,
      extraToppings: this.extraToppings,
      specialPackaging: this.specialPackaging,
    };

    const customValue = `${this.pizzaSize} ${this.topping} ${this.crust}`;
    this.customizationValue = customValue;
    this.orderList.push(customizedPizza);
    console.log(this.orderList);
    this.resetPopup();
  }

  PizzaCustomization() {
    this.pizzaService
      .PizzaCustomization(this.customizationType, this.customizationValue)
      .subscribe((d) => {
        alert(d);
        console.log(d);
      });
  }

  deceratorPatternController() {
    this.pizzaService
      .customizeOrder(this.extraToppings, this.specialPackaging)
      .subscribe((d) => {
        alert(d);
        console.log(d);
      });
  }

  strategyPattern() {
    this.pizzaService
      .PizzaPayment(this.method, this.orderId, this.amount)
      .subscribe((d) => {
        alert('Payment Sucess');
        console.log(d);
      });
  }


  updateStatus(order: any) {
    order.status = this.status;
    this.pizzaService.setStatus(this.status).subscribe(
      (response) => {
        console.log('Status updated successfully:', response);
      },
      (error) => {
        console.error('Error updating status:', error);
      }
    );
  }

  pizzaName = '';

  placeOrder() {
    this.pizzaService.placeOrder(this.pizzaName).subscribe((d) => {
      console.log(d);
    });
  }

  //Feedback provided: test
  provideFeedback() {
    this.pizzaService.provideFeedback(this.feedback).subscribe((d) => {
      alert('Feed back Saved Success');
      console.log(d);
    });
  }

  //Last action undone.
  undo() {
    this.pizzaService.undo().subscribe((d) => {
      console.log(d);
    });
  }

  resetPopup() {
    this.showCustomizationPopup = false;
    this.pizzaSize = 'Medium';
    this.topping = 'Cheese';
    this.crust = 'Thin';
    this.extraToppings = false;
    this.specialPackaging = false;
  }
  showFavoritesPopup: boolean = false; // State to toggle the favorites popup
  favoritesList: any[] = []; // Array to store favorite pizzas

  // Toggle the Favorites Popup
  toggleFavoritesPopup() {
    this.showFavoritesPopup = !this.showFavoritesPopup;
  }

  // Add to Favorites Logic
  addToFavorites() {
    if (!this.userProfile) {
      const dialogRef = this.dialog.open(UserProfilePopupComponent, {
        width: '400px',
      });

      dialogRef.afterClosed().subscribe((result) => {
        if (result) {
          this.userProfile = result;
          alert('Profile created successfully! You can now add favorites.');
        }
      });

      return;
    }
    if (!this.pizzaName) {
      alert('Please provide a name for the pizza.');
      return;
    }

    const favoritePizza = {
      name: this.pizzaName,
      size: this.pizzaSize,
      topping: this.topping,
      crust: this.crust,
      extraToppings: this.extraToppings,
      specialPackaging: this.specialPackaging,
    };

    this.favoritesList.push(favoritePizza);
    alert(`${this.pizzaName} added to your favorites!`);
    this.resetPopup();
  }

  notifyCustomer(order: any) {
    // Notify customer of the current status
    alert(`Notification: Your pizza is currently "${order.status}".`);
  }

  updateOrderTracking(order: any, status: string, progress: number) {
    order.status = status;
    order.trackingProgress = progress;
    order.lastUpdated = new Date();
  }

  // export class PizzaOrderComponent {
  //   pizzaService = inject(PizzaServiceService);

  //   // Pizza data
  //   pizzas = [
  //     { name: 'Margherita', description: 'Classic cheese pizza', price: 8.99 },
  //     {
  //       name: 'Pepperoni',
  //       description: 'Loaded with pepperoni slices',
  //       price: 10.99,
  //     },
  //     {
  //       name: 'Veggie',
  //       description: 'Topped with fresh vegetables',
  //       price: 9.99,
  //     },
  //   ];

  //   // Popup control
  //   showCustomizationPopup = false;
  //   selectedPizza: any = null;

  //   // Customization fields
  //   extraToppings = false;
  //   specialPackaging = false;
  //   // customizationType = 'size';
  //   pizzaSize = '';
  //   topping = '';
  //   crust = '';

  //   customizationType = `Customization Types : Size , Topping , Crust`;

  //   customizationValue = `Customization Values : ${this.pizzaSize},${this.topping},${this.crust}`;

  //   // Payment fields
  //   method = 'creditCardPayment';
  //   orderId = '1111';
  //   amount = '233421';

  //   // Open customization popup
  //   openCustomizationPopup(pizza: any) {
  //     this.selectedPizza = pizza;
  //     this.showCustomizationPopup = true;
  //   }

  //   // Close customization popup
  //   closeCustomizationPopup() {
  //     this.showCustomizationPopup = false;
  //   }

  //   // Decorator pattern
  //   deceratorPatternController() {
  //     this.pizzaService
  //       .customizeOrder(this.extraToppings, this.specialPackaging)
  //       .subscribe((d) => {
  //         console.log(d);
  //       });
  //   }

  //   // Chain of responsibility
  //   PizzaCustomization() {
  //     this.pizzaService
  //       .PizzaCustomization(this.customizationType, this.customizationValue)
  //       .subscribe((d) => {
  //         console.log(d);
  //       });
  //   }

  //   // Strategy pattern for payment
  //   strategyPattern() {
  //     this.pizzaService
  //       .PizzaPayment(this.method, this.orderId, this.amount)
  //       .subscribe((d) => {
  //         console.log(d);
  //       });
  //   }

  //   // Factory pattern
  //   PizzaRegisterAndStatus() {
  //     const name = this.selectedPizza?.name || 'Default';
  //     const status_2 = 'baking';
  //     this.pizzaService.PizzaRegister(name).subscribe((d1) => {
  //       console.log('Pizza Register Response:', d1);

  //       this.pizzaService.PizzaStatus(status_2).subscribe((d2) => {
  //         console.log('Pizza Status Response:', d2);
  //       });
  //     });
  //   }

  //   // Command pattern for feedback and undo
  //   provideFeedback() {
  //     const feedback = 'Delicious!';
  //     this.pizzaService.provideFeedback(feedback).subscribe((d) => {
  //       console.log(d);
  //     });
  //   }

  //   undo() {
  //     this.pizzaService.undo().subscribe((d) => {
  //       console.log(d);
  //     });
  //   }
  // }
}
