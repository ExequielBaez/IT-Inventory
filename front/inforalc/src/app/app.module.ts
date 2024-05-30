import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { ElementListComponent } from './components/element-list/element-list.component';
import { HeaderAdminComponent } from './components/header-admin/header-admin.component';
import { Routes, RouterModule } from '@angular/router';
import { ElementAddComponent } from './components/element-add/element-add.component';
import { FormsModule } from '@angular/forms';
import { ElementDetailComponent } from './components/element-detail/element-detail.component';


const routes : Routes = [
  {path:'', component:HomeComponent},
  {path:'admin/element', component: ElementListComponent},
  {path:'admin/element/add', component: ElementAddComponent},
  {path:'admin/element/update/:id', component: ElementAddComponent},
  {path:'admin/detail/:id', component: ElementDetailComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,    
    ElementListComponent, 
    HeaderAdminComponent, 
    ElementAddComponent,
    ElementDetailComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
