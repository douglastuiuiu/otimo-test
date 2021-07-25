import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EmpresasListComponent} from "./empresas/empresas-list.component";
import {EmpresasFormComponent} from "./empresas-form/empresas-form.component";
import {PageNotFoundComponentComponent} from "./page-not-found-component/page-not-found-component.component";

const routes: Routes = [
  { path: 'empresas', component: EmpresasListComponent},
  { path: 'empresas/new', component: EmpresasFormComponent},
  { path: 'empresas/{id}', component: EmpresasFormComponent},
  { path: '**', component: PageNotFoundComponentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
