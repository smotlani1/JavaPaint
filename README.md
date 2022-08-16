# Java Paint Application

This is a paint application based o.the Java Awt Package, 
implementing various design patterns
## Link to GitHub
https://github.com/smotlani1/SE450Final

## Design Patterns Used

### 1. Command Pattern

Classes Used: 
root = src <br/>
model.clickHandler <br/>
canvas.MouseModeCommandInterface <br/>
canvas.MouseModeCommandDraw <br/>
canvas.MouseModeCommandMove<br/>
canvas.MouseModeCommandSelect

### 2. Template Method
canvas.MouseModeCommandDraw <br/>
canvas.CreateRectangle <br/>
canvas.CreateTriangle<br/>
canvas.CreateEllipse
### 3. Abstract Fact. Method
canvas.ShapeFactoryAbstract <br/>
canvas.ShapeFactory <br/>
### 4. State Pattern
canvas.CreateRectangle <br/>
canvas.Rectangle.RectangleAbstract <br/>
canvas.Rectangle.Filled <br/>
canvas.Rectangle.Outlined <br/>
canvas.Rectangle.OutlineFill <br/>
*NOTE* Same pattern is implemented with CreateTriangle and CreateEllipse

### 5. Composite Pattern
canvas.MouseModeCommandDraw (Abstract) <br/>
canvas.Group.GroupShape (Container class) <br/>
canvas.CreateTriangle<br/>


## Bugs/Issues
