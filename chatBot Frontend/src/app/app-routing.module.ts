import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { OauthComponent } from './oauth/oauth.component';
import { AdminloginComponent } from './admin/adminlogin/adminlogin.component';
import { AdminhomeComponent } from './admin/adminhome/adminhome.component';
import { AdminOauthComponent } from './admin/admin-oauth/admin-oauth.component';
import { OauthRegistrationComponent } from './oauth-registration/oauth-registration.component';
import { BotApplicationComponent } from './bot-application/bot-application.component';
import { UserResponseComponent } from './admin/user-response/user-response.component';


const routes: Routes = [
  {
    path : '',
    redirectTo : '/login',
    pathMatch : 'full'

  },
  {
    path : 'login',
    component : LoginComponent

  },
  {
    path : 'register',
    component : RegisterComponent
  },
  {
    path : 'home',
    component : HomeComponent
  },
  {
    path : 'oauth2/redirect',
    component: OauthComponent
  },
  {
    path :'admin/login',
    component : AdminloginComponent
  },
  {
    path : 'admin/home',
    component : AdminhomeComponent
  },
  {
    path:'adminOauth2/redirect',
    component: AdminOauthComponent
  },
  {
    path:'oauthRegistration',
    component: OauthRegistrationComponent
  },
  {
    path:'botApplication',
    component: BotApplicationComponent
  },
  {
    path:'admin/user/response',
    component:UserResponseComponent
  }
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
