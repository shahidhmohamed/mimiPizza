import { CommonModule } from '@angular/common';
import { Component, Inject } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';
import { MatCommonModule } from '@angular/material/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-user-profile-popup',
  imports: [
    MatCardModule,
    MatCommonModule,
    FormsModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
  ],
  templateUrl: './user-profile-popup.component.html',
  styleUrls: ['./user-profile-popup.component.css'],
})
export class UserProfilePopupComponent {
  userProfile = {
    name: '',
    email: '',
    phone: '',
  };

  constructor(
    public dialogRef: MatDialogRef<UserProfilePopupComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  saveProfile() {
    // Pass the userProfile back to the parent component
    this.dialogRef.close(this.userProfile);
  }
}
