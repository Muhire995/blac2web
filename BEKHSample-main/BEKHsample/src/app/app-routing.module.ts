import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateEventComponent } from './create-event/create-event.component';
import { EventComponent } from './event/event.component';
import { EventsComponent } from './events/events.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { NavComponent } from './nav/nav.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  {path: 'events', component:EventsComponent},
  {path: 'login', component:LoginComponent},
  {path: '', component:HomeComponent},
  {path: 'register', component:RegisterComponent},
  {path: 'event', component:EventComponent},
  {path: 'profile/:id/event/:eId', component:EventComponent},
  {path: 'login/signup', component:SignupComponent},
  {path: 'createEvent', component:CreateEventComponent},
  {path: 'profile/:id', component:ProfileComponent},
  {path: 'profile/:id/createEvent', component:CreateEventComponent},
  {path: 'event/:eId', component:EventComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
